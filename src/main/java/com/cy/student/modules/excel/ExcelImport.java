package com.cy.student.modules.excel;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.cy.student.modules.entity.Student_information;
import com.cy.student.modules.service.IStudent_informationService;
import com.cy.student.modules.utils.R;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

@Controller
@RequestMapping("business/student_informations")
public class ExcelImport {
    @Autowired
    private IStudent_informationService student_informationService;

    @RequestMapping(value = "/import")
    public R exImport(@RequestParam(value = "filename") MultipartFile file) {
        boolean a = false;
        String fileName = file.getOriginalFilename();
        try {
            a = student_informationService.batchImport(fileName, file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (a==true){
            return R.ok("操作成功");
        }else {
            return R.error("操作失败");
        }
    }



    @RequestMapping(value = "/export")
    @ResponseBody
    public void export(HttpServletResponse response) throws IOException {
        List<Student_information> studentList = student_informationService.selectList(new EntityWrapper<Student_information>().eq("del_flag",0));

        HSSFWorkbook wb = new HSSFWorkbook();

        HSSFSheet sheet = wb.createSheet("学生信息表");

        HSSFRow row = null;

        row = sheet.createRow(0);//创建第一个单元格
        row.setHeight((short) (26.25 * 20));
        row.createCell(0).setCellValue("学生信息列表");//为第一行单元格设值

        /*为标题设计空间
         * firstRow从第1行开始
         * lastRow从第0行结束
         *
         *从第1个单元格开始
         * 从第3个单元格结束
         */
        CellRangeAddress rowRegion = new CellRangeAddress(0, 0, 0, 2);
        sheet.addMergedRegion(rowRegion);

		/*CellRangeAddress columnRegion = new CellRangeAddress(1,4,0,0);
		sheet.addMergedRegion(columnRegion);*/


        /*
         * 动态获取数据库列 sql语句 select COLUMN_NAME from INFORMATION_SCHEMA.Columns where table_name='user' and table_schema='test'
         * 第一个table_name 表名字
         * 第二个table_name 数据库名称
         * */
        row = sheet.createRow(1);
        row.setHeight((short) (22.50 * 20));//设置行高
        row.createCell(0).setCellValue("学生姓名");//为第一个单元格设值
        row.createCell(1).setCellValue("学生联系方式");//为第二个单元格设值
        row.createCell(2).setCellValue("学生专业");//为第三个单元格设值
        row.createCell(3).setCellValue("学生班级");//为第三个单元格设值
        row.createCell(4).setCellValue("学生备注");//为第三个单元格设值

        for (int i = 0; i < studentList.size(); i++) {
            row = sheet.createRow(i + 2);
            Student_information student_information = studentList.get(i);
            row.createCell(0).setCellValue(student_information.getStudent_name());
            row.createCell(1).setCellValue(student_information.getStudent_phone());
            row.createCell(2).setCellValue(student_information.getMajor_id());
            row.createCell(3).setCellValue(student_information.getClass_id());
            row.createCell(4).setCellValue(student_information.getRemark());
        }
        sheet.setDefaultRowHeight((short) (16.5 * 20));
        //列宽自适应
        for (int i = 0; i <= 13; i++) {
            sheet.autoSizeColumn(i);
        }

        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        OutputStream os = response.getOutputStream();
        response.setHeader("Content-disposition", "attachment;filename=student.xls");//默认Excel名称
        wb.write(os);
        os.flush();
        os.close();


    }

}
