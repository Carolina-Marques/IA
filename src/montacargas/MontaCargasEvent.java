package montacargas;

import java.util.EventObject;

public class MontaCargasEvent extends EventObject {

    public MontaCargasEvent(MontaCargasState source) {
        super(source);
    }
}
