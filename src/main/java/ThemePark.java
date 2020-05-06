import attractions.Attraction;
import behaviours.IReviewed;
import people.Visitor;

import java.util.ArrayList;
import java.util.HashMap;

public class ThemePark {
    private ArrayList<IReviewed> allReviewed;
    private HashMap<String, Integer> reviews;

    public ThemePark() {
        this.allReviewed = new ArrayList<>();
        this.reviews = new HashMap<>();
    }

    public ArrayList<IReviewed> getAllReviewed() {
        return allReviewed;
    }

    public void addStall(IReviewed stall) {
        allReviewed.add(stall);
    }

    public void visit(Visitor visitor, Attraction attraction){
        attraction.setVisitCount(attraction.getVisitCount() + 1 );
        visitor.addAttraction(attraction);
    }

    public HashMap reviews(){
        for ( IReviewed review : allReviewed){
            reviews.put(review.getName(), review.getRating());
        }
        return reviews;
    }

//    ThemePark has a method getAllAllowedFor(Visitor)
//    which takes a Visitor and returns an ArrayList of IReviewed that the visitor is allowed to go on.
    // (Attraction)allrevied.isAllowed



}
