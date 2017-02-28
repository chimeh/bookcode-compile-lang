package DecoratorPattern;

import java.util.LinkedList;
import java.util.List;

public class TextField implements GraphicalComponent {

    private List<String> lines = new LinkedList<String>();

    @Override
    public void paint() {
        System.out.println("Start textfield....");

        for(String l: this.lines) {
            System.out.println(l);
        }
        System.out.println("End Textfield");
    }

    @Override
    public GraphicalComponent addContent(Object content) {
        assert(content instanceof String);
        this.lines.add((String)content);

        if(this.lines.size() > 2) {
            return new ScrollbarDecorator(this);
        }

        return this;
    }
}
