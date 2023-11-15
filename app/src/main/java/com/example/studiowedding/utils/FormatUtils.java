package com.example.studiowedding.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class FormatUtils {
    /**
     * Chuyển đổi một đối tượng Date thành một chuỗi có định dạng "yyyy-MM-dd".
     *
     * @param date Đối tượng Date cần chuyển đổi.
     * @return Biểu diễn chuỗi ngày ở định dạng "yyyy-MM-dd".
     */
    public static String dateToString(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        return sdf.format(date);
    }

    /**
     * Chuyển đổi một chuỗi có định dạng "dd/MM/yyyy" thành đối tượng Ngày.
     *
     * @param dateString Chuỗi biểu thị ngày ở định dạng "yyyy-MM-dd".
     * @return Một đối tượng Date được phân tích cú pháp từ chuỗi đầu vào.
     * @throws ParseException Nếu chuỗi đầu vào không thể được phân tích thành đối tượng Date.
     */
    public static Date stringToDate(String dateString) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        return sdf.parse(dateString);
    }
}
