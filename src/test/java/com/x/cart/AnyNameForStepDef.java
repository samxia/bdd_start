package com.x.cart;

import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.math.BigDecimal;
import java.util.*;

import static org.junit.Assert.assertEquals;

//product picked up
class  ProductPicked{
    int number;
    Product product;
    public ProductPicked(int num,Product pro)
    {
        this.number = num;
        this.product = pro;
    }
}

public class AnyNameForStepDef {

    ShopCart cart = new ShopCart();

    /*The productMap contains the products of markets, data from the DataTable
    * static for set once.
     */
    static Map<String,Product> productMap = new HashMap<>();

    //picked products are in this list,plus the number
    List<ProductPicked> productPickedList = new ArrayList<>();

    ProductPicked productPicked;
    @DataTableType
    public Product productEntry(Map<String,String> entry)
    {
      //debug
     /*   for(Iterator iter = entry.keySet().iterator(); iter.hasNext();)
        {
            System.out.println((String)iter.next());
        }
        System.out.println(entry.get("no"));
     */
        int no = Integer.valueOf(entry.get("no"));
        String name = entry.get("name");
        Double price =Double.parseDouble(entry.get("price"));
        String note = entry.get("note");

        return new Product(no,name,BigDecimal.valueOf(price),note);

    }

    //Data come from the DataTable of the feature file
    @Given("The market has the following products:")
    public void the_market_has_the_following_products(List<Product> products){
        //put the DataTable's data to productMap
        //Because this Given is  for Background, it will run every scenario
        //so set the product map to static
        if(productMap.size() == 0) {
             for (Iterator iter = products.iterator(); iter.hasNext(); ) {
                 Product p = (Product) iter.next();
                 productMap.put(p.getName(), p);
             }
             //System.out.println("Size: " + products.size());
         }
    }

    @Given("I pick up {int} {word}")
    public void i_pick_up_pair(Integer int1,String product_name) {
        /*get the product by the product_name,and put it to the picked list
         productPickedList.add(
                 new ProductPicked(int1,
                         productMap.get((product_name))));
 */
        productPicked = new ProductPicked(int1,productMap.get(product_name));
        //System.out.println("pick up   :" + int1 + "--" + product_name);
        //add the picked product to the list
        productPickedList.add(productPicked);
        //Product p =productMap.get(product_name);
        //System.out.println(p.getName() + p.getPrice());

    }

    @When("I add the products to cart")
    public void i_add_the_products_to_cart() {
         for(Iterator iter =  productPickedList.iterator();iter.hasNext();)
         {
             ProductPicked pp=(ProductPicked)iter.next();
            //product env,should not do this
             if(pp.number == 0)
             {
                 return;
             }
             cart.add(pp.product,pp.number);
         }
    }
  /*  @Then("I should be told the total price is {int}}")
    public void i_should_be_told_the_total_price_is(Integer int1) {

        throw new io.cucumber.java.PendingException();
    }
 */
    @Given("pick up {int} rices")
    public void pick_up_rices(Integer int1) {
        //throw new io.cucumber.java.PendingException();
    }

    @Then("I should be told {string}")
    public void i_should_be_told(String string) {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
        System.out.println("no implement");
    }

    @Then("I should be told the total price is {double}")
    public void i_should_be_told_the_total_price_is(double db) {
        assertEquals(BigDecimal.valueOf(db),cart.totalPrice);
        cart.print();
    }

}