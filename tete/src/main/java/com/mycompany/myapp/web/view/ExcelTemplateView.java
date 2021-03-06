package com.mycompany.myapp.web.view;

import java.io.InputStream;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Workbook;
import org.jxls.common.Context;
import org.jxls.util.JxlsHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

public abstract class ExcelTemplateView extends AbstractXlsxView {

    //private static String template = "/view/computational/storeopenreport_template.xls";

    private static final Logger LOG = LoggerFactory.getLogger(ExcelTemplateView.class);

    @Override
    protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        String template = (String) model.get("template");
        String excelName = (String) model.get("excelName");
        //String colKey = (String) model.get("colKey");

        LOG.info("Running Custom Expression Notation ExcelTemplateView");
        try(InputStream is = ExcelTemplateView.class.getResourceAsStream(template)) {

            Context context = setContent(model);
            //Context context = new Context();
            //context.putVar("title", model.get("title"));

            //for (String mapkey : model.keySet()){
            //    context.putVar(mapkey, model.get(model.keySet()));
            //    System.out.println("key:"+mapkey+",value:"+model.get(mapkey));
            //}

            //context.putVar("report_month", 8);
            //context.putVar(colKey, model.get("colValue"));
            response.setContentType(getContentType());
            response.setHeader("content-disposition",
                    "attachment;filename=" + excelName + ".xls");
            ServletOutputStream os = response.getOutputStream();

            JxlsHelper.getInstance().processTemplate(is, os, context);
            //JxlsHelper.getInstance().processTemplateAtCell(is, os, context, "Result!A1");
            is.close();

        }

    }

    abstract protected Context setContent(Map<String, Object> model);

}
