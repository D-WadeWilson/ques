package com.yz.questionnaire.Utils;

import com.yz.questionnaire.entity.UserExportDTO;
import org.apache.poi.hpsf.DocumentSummaryInformation;
import org.apache.poi.hpsf.SummaryInformation;
import org.apache.poi.hssf.record.PageBreakRecord;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;

public class UserUtils {

    public static ResponseEntity<byte[]> exportUser(List<UserExportDTO> userExportDTOList) {
        //1.创建一个excel文档
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
        //2.创建文档摘要
        hssfWorkbook.createInformationProperties();
        //3.获取并配置文档摘要信息
        DocumentSummaryInformation docInfo = hssfWorkbook.getDocumentSummaryInformation();
        //文档类别
        docInfo.setCategory("返回问卷信息");
        //文档管理员
        docInfo.setManager("wilson");
        //文档所属公司
        docInfo.setCompany("国元网金");
        //文档版本
        docInfo.setApplicationVersion(1);
        //4.获取文档摘要信息
        SummaryInformation summaryInformation = hssfWorkbook.getSummaryInformation();
        //文档标题
        summaryInformation.setAuthor("questionnaire");
        //文档创建时间
        summaryInformation.setCreateDateTime(new Date());
        //文档备注
        summaryInformation.setComments("第一版");
        //5.创建样式
        //创建标题行的样式
        HSSFCellStyle headerStyle = hssfWorkbook.createCellStyle();
        //设置该样式的图案颜色为黄色
//        headerStyle.setFillForegroundColor(IndexedColors.GREEN.index);//设置图案颜色
//        headerStyle.setFillBackgroundColor(IndexedColors.RED.index);//设置图案背景色
        headerStyle.setFillForegroundColor(IndexedColors.YELLOW.index);
        //设置图案填充的样式
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        //设置日期相关的样式
        HSSFCellStyle dateCellStyle = hssfWorkbook.createCellStyle();
        //这里的m/d/yy 相当于yyyy-MM-dd
        dateCellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy"));
        HSSFSheet sheet = hssfWorkbook.createSheet("问卷调查信息表");
        //设置每一列的宽度
        sheet.setColumnWidth(0,5*256);
        sheet.setColumnWidth(1,10*256);
        sheet.setColumnWidth(2,12*256);
        sheet.setColumnWidth(3,10*256);
        sheet.setColumnWidth(4,10*256);
        sheet.setColumnWidth(5,12*256);
        sheet.setColumnWidth(6,20*256);
        for (int i = 0; i < 25 ; i++) {
            sheet.setColumnWidth(i+7,8*256);
        }

        //6.创建标题行
        HSSFRow r0 = sheet.createRow(0);
        HSSFCell c0 = r0.createCell(0);
        c0.setCellValue("编号");
        c0.setCellStyle(headerStyle);
        HSSFCell c1 = r0.createCell(1);
        c1.setCellStyle(headerStyle);
        c1.setCellValue("姓名");
        HSSFCell c2 = r0.createCell(2);
        c2.setCellStyle(headerStyle);
        c2.setCellValue("电话");
        HSSFCell c3 = r0.createCell(3);
        c3.setCellStyle(headerStyle);
        c3.setCellValue("问卷类型");
        HSSFCell c4 = r0.createCell(4);
        c4.setCellStyle(headerStyle);
        c4.setCellValue("所属市");
        HSSFCell c5 = r0.createCell(5);
        c5.setCellStyle(headerStyle);
        c5.setCellValue("所属县");
        HSSFCell c6 = r0.createCell(6);
        c6.setCellStyle(headerStyle);
        c6.setCellValue("所属小区");
        for (int i = 0; i < 25 ; i++) {
            HSSFCell cc = r0.createCell(i+7);
            cc.setCellStyle(headerStyle);
            cc.setCellValue("第"+ ((i+1)) +"题");
        }


        for (int i = 0; i < userExportDTOList.size(); i++) {
            UserExportDTO userExportDTO= userExportDTOList.get(i);
            HSSFRow row = sheet.createRow(i+1);
            row.createCell(0).setCellValue(i+1);
            row.createCell(1).setCellValue(userExportDTO.getName());
            row.createCell(2).setCellValue(userExportDTO.getPhone());
            String type = "";
            switch (userExportDTO.getType()){
                case 1:
                    type = "未建档";
                    break;
                case 2:
                    type = "未脱困";
                    break;
                case 3:
                    type = "已脱困";
                    break;
                case 4:
                    type = "注销户";
                    break;
                default:
                    type = "未建档";
            }
            row.createCell(3).setCellValue(type);
//            HSSFCell cell4 = row.createCell(4);
//         //单独设置日期的样式
//            cell4.setCellStyle(dateCellStyle);
//            cell4.setCellValue(employee.getBirthday());
            row.createCell(4).setCellValue(userExportDTO.getCity());
            row.createCell(5).setCellValue(userExportDTO.getTown());
            row.createCell(6).setCellValue(userExportDTO.getHouse());
            String answerStr = userExportDTO.getAnswer();
            String[] answers = answerStr.split(",");
            for (int j = 0; j < answers.length; j++) {
                row.createCell(j+7).setCellValue(answers[j]);
            }
        }
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        HttpHeaders headers = new HttpHeaders();
        try {
            //将数据表这几个中文的字转码 防止导出后乱码
            headers.setContentDispositionFormData("attachment",
                    new String("data.xls".getBytes("UTF-8"),"ISO-8859-1"));
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            hssfWorkbook.write(stream);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<byte[]>(stream.toByteArray(),headers, HttpStatus.CREATED);
    }
}