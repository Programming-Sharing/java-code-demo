package com.ps.routingdatasources.datasource;

public class BranchContextHolder {
    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void setBranchContext(String branch){
        threadLocal.set(branch);
    }

    public static String getCurrentBranch(){
        return threadLocal.get();
    }

    public static void clearContext(){
        threadLocal.remove();
    }
}
