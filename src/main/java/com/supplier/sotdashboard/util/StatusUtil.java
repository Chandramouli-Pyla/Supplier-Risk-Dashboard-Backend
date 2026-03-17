package com.supplier.sotdashboard.util;

import com.supplier.sotdashboard.enums.Status;

public class StatusUtil {

    private StatusUtil() {
    }

    public static Status getStatusFromDelay(Integer delayDays) {
        if (delayDays == null) {
            return Status.OPEN;
        }
        if (delayDays <= 2) {
            return Status.GREEN;
        }
        if (delayDays <= 5) {
            return Status.YELLOW;
        }
        return Status.RED;
    }
}