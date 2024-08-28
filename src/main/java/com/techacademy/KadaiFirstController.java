package com.techacademy;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KadaiFirstController {

    @GetMapping("/dayofweek/{today}")
    public String dispDayOfWeek(@PathVariable String today) {
        // 日付を解析するためのフォーマッタを作成
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        // 文字列をLocalDateオブジェクトに変換
        LocalDate date = LocalDate.parse(today, formatter);

        // 曜日を指定の形式で取得
        DayOfWeek dayOfWeek = date.getDayOfWeek();

        String formattedDayOfWeek = dayOfWeek.toString().substring(0, 1).toUpperCase() +
                                    dayOfWeek.toString().substring(1).toLowerCase();
        // 曜日を表示
        return formattedDayOfWeek;
    }
    // 足し算
    @GetMapping("/plus/{num1}/{num2}")
    public String calcPlus(@PathVariable int num1, @PathVariable int num2) {
        int result = num1 + num2;
        return String.valueOf(result);
    }

    // 引き算
    @GetMapping("/minus/{num1}/{num2}")
    public String calcMinus(@PathVariable int num1, @PathVariable int num2) {
        int result =num1 - num2;
        return String.valueOf(result);
    }

    // 掛け算
    @GetMapping("/times/{num1}/{num2}")
    public String calcTimes(@PathVariable int num1, @PathVariable int num2) {
        int result = num1 * num2;
        return String.valueOf(result);
    }

    // 割り算
    @GetMapping("/divide/{num1}/{num2}")
    public String calcDivide(@PathVariable int num1, @PathVariable int num2) {
        if (num2 == 0) {
            return "Error: Division by zero";
        }
        int result = num1 / num2;
        return String.valueOf(result);
    }
}
