import java.io.*;
import java.util.StringTokenizer;
import java.util.zip.DataFormatException;

/**
 * @author YXH_XianYu
 * Created On 2022-05-17
 */
public class FileCatalogLoader implements CatalogLoader {

    private Product readProduct(String line) throws DataFormatException {
        StringTokenizer st = new StringTokenizer(line, "_");
        if(st.countTokens() != 4) {
            throw new DataFormatException(line);
        }
        st.nextToken();
        String code = st.nextToken();
        String description = st.nextToken();

        double price;
        try {price = Double.parseDouble(st.nextToken());}
        catch (NumberFormatException e) {throw new DataFormatException(line);}

        return new Product(code, description, price);
    }

    private Coffee readCoffee(String line) throws DataFormatException {
        StringTokenizer st = new StringTokenizer(line, "_");
        if(st.countTokens() != 10) {
            throw new DataFormatException(line);
        }
        st.nextToken();
        String code = st.nextToken();
        String description = st.nextToken();

        double price;
        try {price = Double.parseDouble(st.nextToken());}
        catch (NumberFormatException e) {throw new DataFormatException(line);}

        String origin = st.nextToken();
        String roast = st.nextToken();
        String flavor = st.nextToken();
        String aroma = st.nextToken();
        String acidity = st.nextToken();
        String body = st.nextToken();

        return new Coffee(code, description, price, origin, roast, flavor, aroma, acidity, body);
    }

    private CoffeeBrewer readCoffeeBrewer(String line) throws DataFormatException {
        StringTokenizer st = new StringTokenizer(line, "_");
        if(st.countTokens() != 7) {
            throw new DataFormatException(line);
        }
        st.nextToken();
        String code = st.nextToken();
        String description = st.nextToken();

        double price;
        try {price = Double.parseDouble(st.nextToken());}
        catch (NumberFormatException e) {throw new DataFormatException(line);}

        String model = st.nextToken();
        String waterSupply = st.nextToken();

        int numberOfCups;
        try {numberOfCups = Integer.parseInt(st.nextToken());}
        catch (NumberFormatException e) {throw new DataFormatException(line);}

        return new CoffeeBrewer(code, description, price, model, waterSupply, numberOfCups);
    }


    public Catalog loadCatalog(String fileName) throws FileNotFoundException, IOException, DataFormatException {
        BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));

        Catalog catalog = new Catalog();

        String str;
        while((str = input.readLine()) != null) {
            if(str.startsWith("Product"))
                catalog.addProduct(readProduct(str));
            else if(str.startsWith("Coffee"))
                catalog.addProduct(readCoffee(str));
            else if(str.startsWith("Brewer"))
                catalog.addProduct(readCoffeeBrewer(str));
        }
        return catalog;
    }


}
