package com.cy.student.modules.service.impl;

import com.cy.student.modules.entity.StudentInformation;
import com.cy.student.modules.mapper.StudentInformationMapper;
import com.cy.student.modules.service.IStudentInformationService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cy.student.modules.utils.MyException;
import com.cy.student.modules.utils.PageUtils;
import com.cy.student.modules.utils.check.CheckUtils;
import com.cy.student.modules.utils.dao.DaoUtils;
import com.cy.student.modules.utils.factory.PageUtilsFactory;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 学生信息表 服务实现类
 * </p>
 *
 * @author 袁帅
 * @since 2019-03-21
 */
@Service
public class StudentInformationServiceImpl extends ServiceImpl<StudentInformationMapper, StudentInformation> implements IStudentInformationService {

    @Autowired
    private IStudentInformationService student_informationService;

    @Autowired
    private DaoUtils<StudentInformation> dateUtils;
    @Override
    public PageUtils queryPage(Map<String, Object> params) {

        Object studentname=params.get("student_name");

        String sql = "select sti.*,class.class_name,teacher.teacher_name\n" +
                "from student_information as sti\n" +
                "left join class_table as class on sti.class_id=class.id\n" +
                "left join teacher_information as teacher on sti.guidanceteacher_id=teacher.id where sti.del_flag=0";

        if (CheckUtils.isNotNull(studentname)){
            sql+=" and sti.student_name  like '%"+studentname+"%' ";
        }

        sql += " order by sti.id desc";
        return this.dateUtils.findBySql(sql, PageUtilsFactory.getInstance(params) );
    }


    @Transactional(readOnly = false,rollbackFor = Exception.class)
    @Override
    public boolean batchImport(String fileName, MultipartFile file) throws Exception {
        boolean notNull = false;
        List<StudentInformation> studentList = new ArrayList<>();
        if (!fileName.matches("^.+\\.(?i)(xls)$") && !fileName.matches("^.+\\.(?i)(xlsx)$")) {
            throw new MyException("上传文件格式不正确");
        }
        boolean isExcel2003 = true;
        if (fileName.matches("^.+\\.(?i)(xlsx)$")) {
            isExcel2003 = false;
        }
        InputStream is = file.getInputStream();
        Workbook wb = null;
        if (isExcel2003) {
            wb = new HSSFWorkbook(is);
        } else {
            wb = new XSSFWorkbook(is);
        }
        Sheet sheet = wb.getSheetAt(0);
        if(sheet!=null){
            notNull = true;
        }
        StudentInformation student;
        for (int r = 2; r <= sheet.getLastRowNum(); r++) {//r = 2 表示从第三行开始循环 如果你的第三行开始是数据
            Row row = sheet.getRow(r);//通过sheet表单对象得到 行对象
            if (row == null){
                continue;
            }

            //sheet.getLastRowNum() 的值是 10，所以Excel表中的数据至少是10条；不然报错 NullPointerException

            student = new StudentInformation();

            if( row.getCell(0).getCellType() !=1){//循环时，得到每一行的单元格进行判断
                throw new MyException("导入失败(第"+(r+1)+"行,用户名请设为文本格式)");
            }

            String student_name = row.getCell(0).getStringCellValue();//得到每一行第一个单元格的值
            if(student_name == null || student_name.isEmpty()){//判断是否为空
                throw new MyException("导入失败(第"+(r+1)+"行,学生姓名未填写)");
            }


            row.getCell(1).setCellType(1);//得到每一行的 第二个单元格的值
            String student_phone = row.getCell(1).getStringCellValue();
            if(student_phone==null || student_phone.isEmpty()){
                throw new MyException("导入失败(第"+(r+1)+"行,电话未填写)");
            }

            row.getCell(1).setCellType(2);//得到每一行的 第二个单元格的值
            String major_id = row.getCell(2).getStringCellValue();
            if(major_id==null || major_id.isEmpty()){
                throw new MyException("导入失败(第"+(r+1)+"行,专业未填写)");
            }

            row.getCell(1).setCellType(3);//得到每一行的 第二个单元格的值
            String class_id = row.getCell(3).getStringCellValue();
            if(class_id==null || class_id.isEmpty()){
                throw new MyException("导入失败(第"+(r+1)+"行,班级未填写)");
            }

            row.getCell(1).setCellType(4);//得到每一行的 第二个单元格的值
            Date dateofbirth = row.getCell(4).getDateCellValue();
            if(dateofbirth==null){
                throw new MyException("导入失败(第"+(r+1)+"行,出生日期未填写)");
            }

            row.getCell(1).setCellType(5);//得到每一行的 第二个单元格的值
            String remark = row.getCell(5).getStringCellValue();
            if(remark==null||remark.isEmpty()){
                throw new MyException("导入失败(第"+(r+1)+"行,出生日期未填写)");
            }


            //完整的循环一次 就组成了一个对象
            student.setStudent_name(student_name);
            student.setStudent_phone(student_phone);
            student.setMajor_id(major_id);
            student.setClass_id(class_id);
            student.setDateofbirth(dateofbirth);
            student.setRemark(remark);

            studentList.add(student);
        }
        for (StudentInformation userResord : studentList) {
            student_informationService.insert(userResord);
            System.out.println(" 插入 "+userResord);
//            String name = userResord.getUsername();
//            int cnt = userMapper.selectByName(name);
//            if (cnt == 0) {
//                userMapper.addUser(userResord);
//                System.out.println(" 插入 "+userResord);
//            } else {
//                userMapper.updateUserByName(userResord);
//                System.out.println(" 更新 "+userResord);
//            }
        }
        return notNull;
    }

}
