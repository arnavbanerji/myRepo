import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NoDataException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.linear.LUDecomposition;
import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;

public class LinearRegression {

    private RealMatrix w, estimate;

    public RealMatrix getW() { return w; }
    public RealMatrix getEstimate() { return estimate; }

    public LinearRegression(double[][] xArray, double[][] yArray) throws DimensionMismatchException, NullArgumentException, NoDataException, Exception {
        applyNormalEquation(MatrixUtils.createRealMatrix(xArray),MatrixUtils.createRealMatrix(yArray));
    }

    //normal equation formula = w = (X'X)^-1 X'Y
    //hypothesis = h(X) = w'X
    private void applyNormalEquation(RealMatrix x, RealMatrix y) throws Exception {
        LUDecomposition luDecomposition = new LUDecomposition(x.transpose().multiply(x));
        if(luDecomposition.getDeterminant() == 0.0) throw new Exception("singlular matrix with no matrix");
        else {
            w = luDecomposition.getSolver().getInverse().multiply(x.transpose().multiply(y));
        }
        estimate = x.multiply(w);
    }

    public double estimateRent(String entry) {
        double[] entryMatrix = {1, Double.valueOf(entry)};
        return MatrixUtils.createColumnRealMatrix(entryMatrix).transpose().multiply(w).getData()[0][0];
    }
}
