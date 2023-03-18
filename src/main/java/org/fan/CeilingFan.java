package org.fan;

import java.time.LocalDate;

public class CeilingFan {
    private int speed;  // 0 - off, 1 - low, 2 - medium, 3 - high
    private boolean isReversed;
    private boolean isOffOnChristmas;

    public CeilingFan() {
        speed = 0;
        isReversed = false;
        isOffOnChristmas = false;
    }

    public void pullSpeedCord() {
        if (isOffOnChristmas) {
            return;
        }
        if (speed == 3) {
            speed = 0;
        } else {
            speed++;
        }
    }

    public void pullDirectionCord() {
        if (isOffOnChristmas) {
            return;
        }
        isReversed = !isReversed;
    }

    public void setOffOnChristmas(boolean isOffOnChristmas) {
        this.isOffOnChristmas = isOffOnChristmas;
    }

    public boolean isOffOnChristmas() {
        return isOffOnChristmas;
    }

    public int getSpeed() {
        return speed;
    }

    public boolean isReversed() {
        return isReversed;
    }
}
