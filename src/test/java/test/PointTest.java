package test;

import classes.Point;
import org.junit.Assert;
import org.junit.Test;

public class PointTest {

    @Test
    public void givenArray_searchRowMinimum_thenReturnMin() {
        Point pt = new Point();
        double [][] row = {{2.2, 7.5, 3.2, 0.25, 9.0, 5.2}};

        double actualMinimum = pt.rowMinimum(row, 0);
        double exceptedMinimum = 0.25;

        Assert.assertEquals(actualMinimum, exceptedMinimum, 2);
    }

    @Test
    public void givenArray_searchColMaximum_thenReturnMax() {
        Point pt = new Point();
        double [][] col = {{2.2, 7.5, 3.2, 0.25, 9.0, 5.2},
                           {7.4, 7.5, 3.2, 0.25, 9.0, 5.2},
                           {5.1, 7.5, 3.2, 0.25, 9.0, 5.2},
                           {1.6, 7.5, 3.2, 0.25, 9.0, 5.2}};

        double actualMaximum = pt.colMaximum(col, 0);
        double exceptedMaximum = 7.4;

        Assert.assertEquals(actualMaximum, exceptedMaximum, 2);
    }

    @Test
    public void givenArray_checkExcistPoint_thenReturnBoolean() {
        Point pt = new Point();
        double [][] col =
                {{0, 2, 0, 3, 2, 2},
                {0, 2, 0, 2, 2, 2},
                {2, 2, 1, 2, 2, 2},
                {0, 2, 0, 2, 2, 2}};
        pt.setArr(col);

        boolean actualOutput = pt.existPoint();
        boolean exceptedOutput = true;

        Assert.assertEquals(actualOutput, true);
    }

}
