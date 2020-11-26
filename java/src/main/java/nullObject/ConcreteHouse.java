package nullObject;

public class ConcreteHouse extends AbstractHouse{
    private IOrderer orderer;
    private IFormatter formatter;

    public ConcreteHouse(IOrderer orderer, IFormatter formatter) {

        this.orderer = orderer;
        this.formatter = formatter;
        this.data = this.orderer.order(this.data);
        this.data = this.formatter.format(this.data);

    }


    public String recite() {
        StringBuilder builder = new StringBuilder();
        builder.append("This is ");
        for(String str : this.data) {
            builder.append(' ');
            builder.append(str);
        }
        builder.append('.');
        return builder.toString();
    }



}
