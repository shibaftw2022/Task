package admin;

import java.util.ArrayList;
import java.util.List;

public class Admin {

    private List<Setup> setups ;
    private List<View> views;

    public Admin()
    {
        this.setups = new ArrayList<>();
        this.views = new ArrayList<>();
    }
    public List<Setup> getSetups() {
        return setups;
    }

    public void setSetups(List<Setup> setups) {
        this.setups = setups;
    }

    public List<View> getViews() {
        return views;
    }

    public void setViews(List<View> views) {
        this.views = views;
    }
}