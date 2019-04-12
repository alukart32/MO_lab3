public class Method {
    // отрезок
    double
            a = 0, b = 1,
            // точка пересечения с Ox хорды графика f'(x)
            // y = a - (f'(a)/f'(a)-f'(b))*(a-b)
            y,
            // точка, в которой достигается min
            minX,
            // значени min
            Fmin,
            // f(y)
            fy;
    // точность
    double
            eps = 0.05;

    // min на отрезке [ a, b ]
    double min;

    // тестовая функция
    private double F(double x){return Math.pow(x, 4) + Math.exp(-x);}

    private double f(double x){return 4*Math.pow(x, 3) - Math.exp(-x);}

    private double y(){return a - (f(a)/(f(a) - f(b)))*(a-b);}

    public void solve(){
        if(isDifferentSign()){
            int k = 0;

            y = y();
            fy = f(y);

            // если это так, то x* = y, F(x*) = F(y) и поиск завершить
            while (Math.abs(fy) > eps){
                if(fy > 0) {
                    b = y;
                }
                else
                    a = y;
                y = y();
                fy = f(y);
            }
            setMinF(y);
        }
        else{
            switch (isDiffOnEdge()){
                case 0:
                    setMinF(a);
                    break;
                case 1:
                    setMinF(b);
                    break;
                case -1:
                    if(isAscending())
                        setMinF(a);
                    else
                        if(isDescending())
                            setMinF(b);

                    break;
            }
        }
    }


    private void setMinF(double t){
        minX = t;
        Fmin = F(minX);
    }

    private int isDiffOnEdge(){
        if(f(a) == 0)
            return 0;
        else
            if(f(b) == 0)
                return 1;
            else
                return -1;
    }

    private boolean isDifferentSign(){
        return f(a)* f(b) < 0;
    }

    private  boolean isAscending(){
        if(f(a) > 0 & f(b) > 0)
            return true;
        else
            return false;
    }

    private  boolean isDescending(){
        if(f(a) < 0 & f(b) < 0)
            return true;
        else
            return false;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getMinX() {
        return minX;
    }

    public void setMinX(double minX) {
        this.minX = minX;
    }

    public double getFmin() {
        return Fmin;
    }

    public void setFmin(double fmin) {
        Fmin = fmin;
    }

    public double getFy() {
        return fy;
    }

    public void setFy(double fy) {
        this.fy = fy;
    }

    public double getEps() {
        return eps;
    }

    public void setEps(double eps) {
        this.eps = eps;
    }

    public double getMin() {
        return min;
    }

    public void setMin(double min) {
        this.min = min;
    }
}
