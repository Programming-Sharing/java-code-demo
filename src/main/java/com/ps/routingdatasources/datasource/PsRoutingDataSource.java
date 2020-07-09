package com.ps.routingdatasources.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class PsRoutingDataSource extends AbstractRoutingDataSource {
    @Override
    protected String determineCurrentLookupKey() {
        if (BranchContextHolder.getCurrentBranch() != null){
            return BranchContextHolder.getCurrentBranch();
        }
        return null;
    }
}
