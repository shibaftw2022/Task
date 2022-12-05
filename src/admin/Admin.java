package admin;

import java.util.ArrayList;
import java.util.List;

public class Admin {

    private List<Setup> setup ;
    private List<View> view;

    public List<Setup> getSetup() {
        return setup;
    }

    public void setSetup(List<Setup> setup) {
        this.setup = setup;
    }

    public List<View> getView() {
        return view;
    }

    public void setView(List<View> view) {
        this.view = view;
    }
}