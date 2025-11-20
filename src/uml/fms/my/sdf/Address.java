package uml.fms.my.sdf;

public interface Address {
	
	 /**
     * Retourne le nom de la rue.
     */
    public String getRoad();

    /**
     * Retourne le nom de la ville.
     */
    public String getCity();

    /**
     * Retourne le code postal.
     */
    public int getZipCode();

    
    public void setAddress(String road, String city, int zipCode);
}
