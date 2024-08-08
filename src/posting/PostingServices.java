package posting;

import java.util.ArrayList;
public class PostingServices {
    private PostingDAO postingDAO;

    public PostingServices() {
        this.postingDAO = new PostingDAO();
    }

    // Function to see all available postings
    // BUYER
    public ArrayList<Posting> seeAvailablePostings() {
        return postingDAO.getAll();
    }

    // Function to see a specific posting
    // BUYER
    public Posting seeSpecificPosting(int postingId) {
        return postingDAO.getById(postingId);
    }

    // Function to Create posting.Posting
    // SELLER
    public int createPosting(Posting posting) {
        return postingDAO.insert(posting);
    }

    // Function to Update posting.Posting
    // SELLER
    public void updatePosting(Posting posting) {
        postingDAO.update(posting);
    }

    // Function to Delete posting.Posting
    // SELLER
    public void deletePosting(Posting posting) {
        postingDAO.delete(posting);
    }


    // Function to delete all postings by a specific seller
    // ADMIN
    public void deleteAllPostingsBySeller(int sellerId) {
        postingDAO.deleteAllBySeller(sellerId);
    }
  
    // New method to update posting quantity for the Buyer
    public void updatePostingQuantity(int postingId, int newQuantity) {
        Posting posting = postingDAO.getById(postingId);
        if (posting != null) {
            posting.setQuantity(newQuantity);
            postingDAO.update(posting);
        }

    }
}

