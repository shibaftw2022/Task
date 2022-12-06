package admin;

import buyer.Book;

import java.util.*;

public class Admin {

    private Map<Integer,Setup> setupMap;
    private Map<Integer, View> viewMap;

    public Admin()
    {
        this.setupMap = new HashMap<Integer,Setup>();
        this.viewMap =new HashMap<Integer,View>();
    }

    public Map<Integer, Setup> getSetupMap() {
        return setupMap;
    }

    public void setSetupMap(Map<Integer, Setup> setupMap) {
        this.setupMap = setupMap;
    }

    public Map<Integer, View> getViewMap() {
        return viewMap;
    }

    public void setViewMap(Map<Integer, View> viewMap) {
        this.viewMap = viewMap;
    }

    public boolean checkRowInput(int rowInput)
    {
        if (rowInput <= 26 && rowInput > 0) {
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean checkSeatsInput(int seatsInput)
    {
        if (seatsInput <= 10 && seatsInput > 0) {
            return true;
        }
        else
        {
            return false;
        }
    }

    public void addView(Book book)
    {
        if (viewMap.containsKey(book.getShowNumber())) {
            viewMap.get(book.getShowNumber()).getBookings().add(book);
        }
        //View does not exits, add a new view to the map.
        else {
            viewMap.put(book.getShowNumber(), new View());
            viewMap.get(book.getShowNumber()).setBookings(new ArrayList<>(Arrays.asList(book)));
            viewMap.get(book.getShowNumber()).setShowNumber(book.getShowNumber());
        }
    }


}