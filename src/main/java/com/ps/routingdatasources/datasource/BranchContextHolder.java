package com.ps.routingdatasources.datasource;

import com.ps.routingdatasources.BranchList;

public class BranchContextHolder {
    private static ThreadLocal<BranchList> threadLocal = new ThreadLocal<>();

    public static void setBranchContext(BranchList branch){
        threadLocal.set(branch);
    }

    public static BranchList getCurrentBranch(){
        return threadLocal.get();
    }

    public static void clearContext(){
        threadLocal.remove();
    }
}
