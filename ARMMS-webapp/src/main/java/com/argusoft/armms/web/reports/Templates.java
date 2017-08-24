package com.argusoft.armms.web.reports;

import com.argusoft.armms.web.util.SystemConstantUtil;
import java.awt.Color;
import java.util.Locale;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import net.sf.dynamicreports.report.base.expression.AbstractValueFormatter;
import static net.sf.dynamicreports.report.builder.DynamicReports.*;
import net.sf.dynamicreports.report.builder.ReportTemplateBuilder;
import net.sf.dynamicreports.report.builder.component.ComponentBuilder;
import net.sf.dynamicreports.report.builder.component.TextFieldBuilder;
import net.sf.dynamicreports.report.builder.datatype.BigDecimalType;
import net.sf.dynamicreports.report.builder.style.StyleBuilder;
import net.sf.dynamicreports.report.builder.tableofcontents.TableOfContentsCustomizerBuilder;
import net.sf.dynamicreports.report.constant.HorizontalAlignment;
import net.sf.dynamicreports.report.constant.VerticalAlignment;
import net.sf.dynamicreports.report.definition.ReportParameters;

/**
 * General Templates for various reports 
 * @author shreya
 */
public class Templates {

    public static final StyleBuilder rootStyle;
    public static final StyleBuilder boldStyle;
    public static final StyleBuilder italicStyle;
    public static final StyleBuilder boldCenteredStyle;
    public static final StyleBuilder bold8CenteredStyle;
    public static final StyleBuilder bold18CenteredUnderlinedStyle;
    public static final StyleBuilder bold12CenteredStyle;
    public static final StyleBuilder bold12CenteredStyleForSubTitle;
    public static final StyleBuilder bold22CenteredStyle;
    public static final StyleBuilder columnStyle;
    public static final StyleBuilder columnTitleStyle;
    public static final StyleBuilder groupStyle;
    public static final StyleBuilder subtotalStyle;
    public static final ReportTemplateBuilder reportTemplate;
    public static final CurrencyType currencyType;
    public static final ComponentBuilder<?, ?> dynamicReportsComponent;
//    public static final ComponentBuilder<?, ?> footerComponent;
    public static final StyleBuilder labelStyle;
    public static final StyleBuilder contentStyle;
    public static final StyleBuilder contentRightAlignStyle;
    public static final StyleBuilder contentRightAlignStyleWithNoBorder;
    public static final StyleBuilder labelRightAlignStyle;
    public static final StyleBuilder labelStyleWithNoBorder;
    public static final StyleBuilder contentStyleWithNoBorder;
    public static final StyleBuilder staticColumnTitleStyle;

    static {
        rootStyle = stl.style().setPadding(2);

        boldStyle = stl.style(rootStyle).bold();

        italicStyle = stl.style(rootStyle).italic();

        boldCenteredStyle = stl.style(boldStyle)
                .setAlignment(HorizontalAlignment.CENTER, VerticalAlignment.TOP);

        bold8CenteredStyle = stl.style(boldCenteredStyle)
                .setFontSize(8);

        bold12CenteredStyleForSubTitle = stl.style(boldCenteredStyle)
                .setFontSize(12).setBackgroundColor(Color.LIGHT_GRAY);
        
        bold12CenteredStyle = stl.style(boldCenteredStyle)
                .setFontSize(12);

        bold22CenteredStyle = stl.style(boldCenteredStyle)
                .setFontSize(22);

        bold18CenteredUnderlinedStyle = stl.style(boldCenteredStyle)
                .setFontSize(18).setUnderline(Boolean.TRUE);

        columnStyle = stl.style(rootStyle).setVerticalAlignment(VerticalAlignment.TOP).setBorder(stl.penThin()).setFontSize(8);

        columnTitleStyle = stl.style(rootStyle).setVerticalAlignment(VerticalAlignment.MIDDLE)
                .setBorder(stl.penThin()).setFontSize(8)
                .setHorizontalAlignment(HorizontalAlignment.CENTER)
                .setBackgroundColor(Color.LIGHT_GRAY)
                .bold();
        
        groupStyle = stl.style(boldStyle)
                .setHorizontalAlignment(HorizontalAlignment.LEFT);

        subtotalStyle = stl.style(boldStyle)
                .setTopBorder(stl.pen1Point());

        labelStyleWithNoBorder = stl.style()
                .setHorizontalAlignment(HorizontalAlignment.LEFT).setVerticalAlignment(VerticalAlignment.TOP)
                .setPadding(2).bold().setForegroundColor(Color.DARK_GRAY).setFontSize(10);

        contentStyleWithNoBorder = stl.style()
                .setHorizontalAlignment(HorizontalAlignment.LEFT).setVerticalAlignment(VerticalAlignment.TOP)
                .setPadding(2).setForegroundColor(Color.DARK_GRAY).setFontSize(10);

        labelStyle = stl.style()
                .setHorizontalAlignment(HorizontalAlignment.LEFT).setVerticalAlignment(VerticalAlignment.TOP)
                .setBorder(stl.penThin().setLineColor(Color.BLACK)).setPadding(2).bold()
                .setForegroundColor(Color.DARK_GRAY).setFontSize(8);
        contentStyle = stl.style()
                .setHorizontalAlignment(HorizontalAlignment.LEFT).setVerticalAlignment(VerticalAlignment.TOP)
                .setBorder(stl.penThin()).setPadding(2).setFontSize(8);

        contentRightAlignStyle = stl.style()
                .setHorizontalAlignment(HorizontalAlignment.RIGHT).setVerticalAlignment(VerticalAlignment.TOP)
                .setBorder(stl.penThin()).setPadding(2).setFontSize(8);

        contentRightAlignStyleWithNoBorder = stl.style()
                .setHorizontalAlignment(HorizontalAlignment.RIGHT).setVerticalAlignment(VerticalAlignment.TOP)
                .setPadding(2).setFontSize(8);

        labelRightAlignStyle = stl.style()
                .setHorizontalAlignment(HorizontalAlignment.RIGHT).setVerticalAlignment(VerticalAlignment.TOP)
                .setBorder(stl.penThin()).setPadding(2).bold().setFontSize(8);

        staticColumnTitleStyle = stl.style().setPadding(2)
                .setVerticalAlignment(VerticalAlignment.MIDDLE)
                .setBorder(stl.penThin()).setFontSize(8)
                .setHorizontalAlignment(HorizontalAlignment.CENTER)
                .setBackgroundColor(Color.LIGHT_GRAY)
                .bold();



        StyleBuilder crosstabGroupStyle = stl.style(columnTitleStyle);
        StyleBuilder crosstabGroupTotalStyle = stl.style(columnTitleStyle)
                .setBackgroundColor(new Color(170, 170, 170));
        StyleBuilder crosstabGrandTotalStyle = stl.style(columnTitleStyle)
                .setBackgroundColor(new Color(140, 140, 140));
        StyleBuilder crosstabCellStyle = stl.style(columnStyle)
                .setBorder(stl.pen1Point());
        TableOfContentsCustomizerBuilder tableOfContentsCustomizer = tableOfContentsCustomizer()
                .setHeadingStyle(0, stl.style(rootStyle).bold());
        reportTemplate = template()
                .setLocale(Locale.ENGLISH)
                .setColumnStyle(columnStyle)
                .setColumnTitleStyle(columnTitleStyle)
                .setGroupStyle(groupStyle)
                .setGroupTitleStyle(groupStyle)
                .setSubtotalStyle(subtotalStyle)
                //.highlightDetailOddRows()
                //.crosstabHighlightOddRows()
                .setCrosstabGroupStyle(crosstabGroupStyle)
                .setCrosstabGroupTotalStyle(crosstabGroupTotalStyle)
                .setCrosstabGrandTotalStyle(crosstabGrandTotalStyle)
                .setCrosstabCellStyle(crosstabCellStyle)
                .setTableOfContentsCustomizer(tableOfContentsCustomizer);
        currencyType = new CurrencyType();
        dynamicReportsComponent = cmp.horizontalList(cmp.verticalList());
//        footerComponent = cmp.horizontalList().add(Templates.content(new Date()+"", 300)).add(cmp.pageXslashY()
//                .setStyle(contentRightAlignStyleWithNoBorder));
    }
    
    public static TextFieldBuilder<String> content(String text, int size) {
        return label(text, size, contentStyle);
    }

    public static TextFieldBuilder<String> label(String text, int size) {
        return label(text, size, labelStyle);
    }

    public static TextFieldBuilder<String> labelWithNoBorder(String text, int size) {
        return label(text, size, labelStyleWithNoBorder);
    }

    public static TextFieldBuilder<String> labelRightAlign(String text, int size) {
        return label(text, size, labelRightAlignStyle);
    }

    public static TextFieldBuilder<String> contentWithNoBorder(String text, int size) {
        return label(text, size, contentStyleWithNoBorder);
    }

    public static TextFieldBuilder<String> contentRightAlignWithNoBorder(String text, int size) {
        return label(text, size, contentRightAlignStyleWithNoBorder);
    }

    public static TextFieldBuilder<String> contentRightAlign(String text, int size) {
        return label(text, size, contentRightAlignStyle);
    }

    public static TextFieldBuilder<String> columnTitle(String text, int size) {
        return label(text, size, staticColumnTitleStyle);
    }

    public static TextFieldBuilder<String> label(String text, int size, StyleBuilder style) {
        if(text==null || text.equals("null")){
            text= SystemConstantUtil.NOT_AVAILABLE;
        }
//        else{
//            text = text;
//        }
        TextFieldBuilder<String> label = cmp.text(text)
                .setFixedWidth(size);
        if (style != null) {
            label.setStyle(style);
        }
        return label;
    }
    
    /**
     * Creates custom component which is possible to add to any report footer
     * component
     */
    public static ComponentBuilder<?, ?> createFooterComponent() {
        DateFormat df= new SimpleDateFormat("dd/MM/yyyy hh:mm:ss a");
        String date = df.format(new Date());
        return cmp.horizontalList().add(cmp.line().setPen(stl.pen1Point())).newRow().add(cmp.text("Generated on "+ date).setFixedWidth(300).setStyle(stl.style()
                .setHorizontalAlignment(HorizontalAlignment.LEFT).setVerticalAlignment(VerticalAlignment.MIDDLE)
                .setPadding(2).setFontSize(8)))
//                .add(cmp.text("Page -").setStyle(contentRightAlignStyleWithNoBorder.setPadding(0).setFontSize(10).setVerticalAlignment(VerticalAlignment.MIDDLE)))
                .add(cmp.pageXslashY().setStyle(contentRightAlignStyleWithNoBorder.setVerticalAlignment(VerticalAlignment.MIDDLE).setPadding(0).setFontSize(10)));
    }

    /**
     * Creates custom component which is possible to add to any report band
     * component
     */
    public static ComponentBuilder<?, ?> createTitleComponent(String label) {
//        label = CommonUtilBean.getLabelMessageForReport(label);
        return cmp.horizontalList()
                .add(cmp.text(label).setStyle(bold12CenteredStyle).setHorizontalAlignment(HorizontalAlignment.CENTER))
                .newRow()
                .add(cmp.line())
                .newRow()
                .add(cmp.verticalGap(10));
    }

    /**
     * Creates custom component which is possible to add to any report band
     * component
     */
    public static ComponentBuilder<?, ?> createFormTitleComponent(String label) {
//        label = CommonUtilBean.getLabelMessageForReport(label);
        return cmp.horizontalList()
                .add(cmp.text(label).setStyle(bold18CenteredUnderlinedStyle).setHorizontalAlignment(HorizontalAlignment.CENTER))
                .newRow()
                .add(cmp.verticalGap(10));
    }

    public static ComponentBuilder<?, ?> createSubTitleComponent(String label) {
//        label = CommonUtilBean.getLabelMessageForReport(label);
        return cmp.horizontalList()
                .newRow(15)
                .add(cmp.text(label).setStyle(bold12CenteredStyleForSubTitle).setHorizontalAlignment(HorizontalAlignment.CENTER))
                .newRow()
                .add(cmp.verticalGap(10));
    }

    public static CurrencyValueFormatter createCurrencyValueFormatter(String label) {
//        label = CommonUtilBean.getLabelMessageForReport(label);
        return new CurrencyValueFormatter(label);


    }

    public static class CurrencyType extends BigDecimalType {

        private static final long serialVersionUID = 1L;

        @Override
        public String getPattern() {
            return "$ #,###.00";
        }
    }

    private static class CurrencyValueFormatter extends AbstractValueFormatter<String, Number> {

        private static final long serialVersionUID = 1L;
        private String label;

        public CurrencyValueFormatter(String label) {
//            label = CommonUtilBean.getLabelMessageForReport(label);
            this.label = label;
        }

        @Override
        public String format(Number value, ReportParameters reportParameters) {
            return label + currencyType.valueToString(value, reportParameters.getLocale());
        }
    }
}