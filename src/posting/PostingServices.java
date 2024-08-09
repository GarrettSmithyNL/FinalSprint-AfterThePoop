package posting;

import java.util.ArrayList;

/**
 * Service class for managing Posting entities.
 * Provides methods to perform CRUD operations using PostingDAO.
 */
public class PostingServices {
    private PostingDAO postingDAO;

    /**
     * Constructor for PostingServices.
     * Initializes the PostingDAO instance.
     */
    public PostingServices() {
        this.postingDAO = new PostingDAO();
    }

    /**
     * Retrieves all available postings from the database.
     * This method is intended for buyers.
     *
     * @return an ArrayList of Posting objects
     */
    public ArrayList<Posting> seeAvailablePostings() {
        return postingDAO.getAll();
    }

    /**
     * Retrieves a specific posting by its ID.
     * This method is intended for buyers.
     *
     * @param postingId the ID of the posting to retrieve
     * @return the Posting object with the specified ID
     */
    public Posting seeSpecificPosting(int postingId) {
        return postingDAO.getById(postingId);
    }

    /**
     * Creates a new posting in the database.
     * This method is intended for sellers.
     *
     * @param posting the Posting object to create
     * @return the ID of the newly inserted posting, or -1 if the insertion failed
     */
    public int createPosting(Posting posting) {
        return postingDAO.insert(posting);
    }

    /**
     * Updates an existing posting in the database.
     * This method is intended for sellers.
     *
     * @param posting the Posting object with updated information
     */
    public void updatePosting(Posting posting) {
        postingDAO.update(posting);
    }

    /**
     * Deletes a posting from the database.
     * This method is intended for sellers.
     *
     * @param posting the Posting object to delete
     */
    public void deletePosting(Posting posting) {
        postingDAO.delete(posting);
    }

    /**
     * Deletes all postings by a specific seller.
     * This method is intended for administrators.
     *
     * @param sellerId the ID of the seller whose postings to delete
     */
    public void deleteAllPostingsBySeller(int sellerId) {
        postingDAO.deleteAllBySeller(sellerId);
    }

    /**
     * Updates the quantity of a specific posting.
     * This method is intended for buyers.
     *
     * @param postingId the ID of the posting to update
     * @param newQuantity the new quantity to set
     */
    public void updatePostingQuantity(int postingId, int newQuantity) {
        Posting posting = postingDAO.getById(postingId);
        if (posting != null) {
            posting.setQuantity(newQuantity);
            postingDAO.update(posting);
        }
    }
}