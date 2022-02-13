package algorithms.implementation.easy;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;


public class SurfaceArea3DTest {

  @Test
  public void easyInputTest() {
    List<List<Integer>> inputList = List.of(
            List.of(1)
    );
    Assert.assertEquals(6, SurfaceArea3D.surfaceArea(inputList));
  }

  @Test
  public void inputTestTwoCubes() {
    List<List<Integer>> inputList = List.of(
            List.of(1, 1)
    );
    Assert.assertEquals(10, SurfaceArea3D.surfaceArea(inputList));
  }

  @Test
  public void largeInputTest() {
    List<List<Integer>> inputList = List.of(
            List.of(1,3,4),
            List.of(2,2,3),
            List.of(1,2,4)
    );
    Assert.assertEquals(60, SurfaceArea3D.surfaceArea(inputList));
  }
}