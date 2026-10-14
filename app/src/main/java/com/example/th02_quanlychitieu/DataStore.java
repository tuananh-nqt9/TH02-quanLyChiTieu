package com.example.th02_quanlychitieu;

import java.util.ArrayList;

public class DataStore {
    public static ArrayList<Expense> expenseList = new ArrayList<>();
    public static boolean isInitialized = false;

    public static void initData() {
        if (!isInitialized) {
            expenseList.add(new Expense("Ăn sáng", 30000, "Ăn uống", "12/10/2026", "Phở bò"));
            expenseList.add(new Expense("Đổ xăng", 50000, "Đi lại", "12/10/2026", ""));
            expenseList.add(new Expense("Mua sách", 120000, "Học tập", "13/10/2026", "Sách Lập trình Android"));
            isInitialized = true;
        }
    }
}