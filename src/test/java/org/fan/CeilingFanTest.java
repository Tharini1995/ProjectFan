package org.fan;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class CeilingFanTest {
    @Test
    public void testPullSpeedCord() {
        CeilingFan fan = new CeilingFan();
        fan.pullSpeedCord();
        assertEquals(1, fan.getSpeed());
        fan.pullSpeedCord();
        assertEquals(2, fan.getSpeed());
        fan.pullSpeedCord();
        assertEquals(3, fan.getSpeed());
        fan.pullSpeedCord();
        assertEquals(0, fan.getSpeed());
        fan.pullSpeedCord();
        assertEquals(1, fan.getSpeed());
    }

    @Test
    public void testPullDirectionCord() {
        CeilingFan fan = new CeilingFan();
        fan.pullDirectionCord();
        assertTrue(fan.isReversed());
        fan.pullDirectionCord();
        assertFalse(fan.isReversed());
        fan.pullDirectionCord();
        assertTrue(fan.isReversed());
    }

    @Test
    public void testOffOnChristmas() {
        CeilingFan fan = new CeilingFan();
        LocalDate christmas = LocalDate.of(2023, 12, 25);
        LocalDate notChristmas = LocalDate.of(2023, 3, 17);
        fan.setOffOnChristmas(true);
        assertTrue(fan.isOffOnChristmas());
        fan.setOffOnChristmas(false);
        assertFalse(fan.isOffOnChristmas());
        fan.setOffOnChristmas(christmas.getMonth().getValue() == 12 && christmas.getDayOfMonth() == 25);
        assertTrue(fan.isOffOnChristmas());
        fan.setOffOnChristmas(notChristmas.getMonth().getValue() == 12 && notChristmas.getDayOfMonth() == 25);
        assertFalse(fan.isOffOnChristmas());
    }

    @Test
    public void testFanOnChristmas() {
        CeilingFan fan = new CeilingFan();
        LocalDate christmas = LocalDate.of(2023, 12, 25);
        fan.setOffOnChristmas(true);
        fan.pullSpeedCord();
        assertEquals(0, fan.getSpeed());
        fan.pullDirectionCord();
        assertFalse(fan.isReversed());
        fan.pullSpeedCord();
        assertEquals(0, fan.getSpeed());
        fan.pullDirectionCord();
        assertFalse(fan.isReversed());
        fan.pullSpeedCord();
        assertEquals(0, fan.getSpeed());
        fan.pullDirectionCord();
        assertFalse(fan.isReversed());
        fan.pullSpeedCord();
        assertEquals(0, fan.getSpeed());
    }
}
