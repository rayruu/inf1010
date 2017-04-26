public class Legeliste extends OrdnetLenkeliste<Lege> {

    Legeliste(){
      new OrdnetLenkeliste<Lege>();
    }
    /**
     * Soeker gjennom listen etter en lege med samme navn som `navn`
     * og returnerer legen (uten aa fjerne den fra listen).
     * Hvis ingen slik lege finnes, returneres `null`.
     * @param   navn    navnet til legen
     * @return  legen
     */
    public Lege finnLege(String navn) {
      Lege temp;
      temp = null;
      for(Lege lege:this){
        if(navn.compareTo(lege.hentNavn())==0){
          temp = lege;
        }
      }
      if(temp == null){
          return null;
      }else{
          return temp;
      }
    }

    /**
     * Returnerer et String[] med navnene til alle legene i listen
     * i samme rekkefoelge som de staar i listen.
     * @return array med navn til alle legene
     */
    public String[] stringArrayMedNavn() {
      String[] liste = new String[storrelse()];
      int indeks = 0;
      for(Lege navn : this){
        liste[indeks++] = navn.hentNavn();
      }
      if(indeks == 0){
          return null;
      }else{
          return liste;
      }
    }
}
