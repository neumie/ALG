package pkg011.fraction;

/**
 *
 * @author Jakub Neumann
 */
public class Fraction {
    
    private int citatel;
    private int jmenovatel;
    
    public Fraction(int citatel, int jmenovatel){
        this.citatel = citatel;
        this.jmenovatel = jmenovatel;
        setEuklid();
    }
    
    public Fraction(String zlomek){ //z stringu udělá zlomek
        zlomek = zlomek.strip();
        char delimiter;
        if (zlomek.contains("/")) {
            delimiter = '/';
        } else if (zlomek.contains(" ")) {
            delimiter = ' ';
        } else {
            this.citatel = Integer.parseInt(zlomek);
            this.jmenovatel = 1;
            return;
        }
        int i = zlomek.indexOf(delimiter);
        this.citatel = Integer.parseInt(zlomek.substring(0, i));
        this.jmenovatel = Integer.parseInt(zlomek.substring(i+1));
    }
    
    public int getCitatel(){
        return citatel;
    }
    
    public int getJmenovatel(){
        return jmenovatel;
    }
    
    public double toDouble(){
        return (double)citatel / jmenovatel;
    }
    
    @Override
    public String toString(){
        if (jmenovatel == 1) {
            return String.format("%d", citatel);
        }
        return String.format("%d/%d", citatel, jmenovatel);
    }
    
//    private void euklid(){
//        int u = citatel;
//        int w = jmenovatel;
//        int r;
//        while (w != 0) {
//            r = u % w;
//            u = w;
//            w = r;
//        }
//        citatel /= u;
//        jmenovatel /=  u;
//    }
    
    public int euklid(int u, int w){
        int r;
        while (w != 0) {
            r = u % w;
            u = w;
            w = r;
        }
        return u;
    }
    
    public void setEuklid(){
        int u = euklid(citatel, jmenovatel);
        citatel /= u;
        jmenovatel /= u;
    }
    
}