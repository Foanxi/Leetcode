package easy;

public class T812_largestTriangleArea {
    public double largestTriangleArea(int[][] points) {
        double area =0.0;
        double x1,x2,x3,y1,y2,y3;
        int length = points.length;
        //选择起点
        for (int i=0;i<length-2;i++){
            x1 = points[i][0];
            y1 = points[i][1];
            for (int j=i+1;j<length-1;j++){
                x2 = points[j][0];
                y2 = points[j][1];
                for (int k=j+1;k<length;k++){
                    x3 = points[k][0];
                    y3 = points[k][1];
                    area = Math.max(Math.abs((1.0/2)*(x1*y2+x2*y3+x3*y1-x1*y3-x2*y1-x3*y2)),area);
                }
            }
        }
        return area;
    }

    public static void main(String[] args) {
        int[][] points = {{0,0},{0,1},{1,0}};
        System.out.println(new T812_largestTriangleArea().largestTriangleArea(points));
    }
}
