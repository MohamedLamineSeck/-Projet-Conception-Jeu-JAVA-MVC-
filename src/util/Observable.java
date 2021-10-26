package util;


/**
 * Define an observable object.
 */
public interface Observable {

    /**
     * Adds an observer to the observable object.
     *
     * @param obs An observer
     */
    void addObserver(Observer obs);

    /**
     * Removes an observer from the observable object.
     *
     * @param obs An observer
     */
    void removeObserver(Observer obs);

    /**
     * Notify observer from changes.
     *
     * @param obj The changed object to be sent
     */
    void notifyObserver(Object obj);

	

}
