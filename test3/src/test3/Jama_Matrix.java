package test3;

import Jama.Matrix;

public class Jama_Matrix {
    public static void main(String[] args) {
      double [][] array = {
              {1,3},
              {2,6},
              {3,7}};
      //定义一个矩阵
      Matrix A = new Matrix(array);

      //由特征值组成的对角矩阵
      A.eig().getD().print(10,2);
      //每一列对应的是一个特征向量
       A.eig().getV().print(4,2);

//    double [][] arrayb = {
//              {1,-2,2},
//              {-2,-2,4},
//              {2 ,4,-2}};
//      Matrix B = new Matrix(arrayb);
//      B.eig().getD().print(4,2);
//      B.eig().getV().print(4,2);
    }
}