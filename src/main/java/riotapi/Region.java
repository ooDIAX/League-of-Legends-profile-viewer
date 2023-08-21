package riotapi;

public class Region {

    public static String generealRegion(String region) throws Exception {
        String strUrl = "";

        switch (region) {
            case "europe", "Europe", "EU" -> strUrl = "https://europe";
            case "Americas", "America", "NA" ->
                    strUrl = "https://americas";
            case "Asia", "ASIA", "asia" -> strUrl = "https://asia";
            case "sea", "SEA" -> strUrl = "https://sea";
            default -> {
                throw new Exception("wrong region");
            }
        }

        return strUrl;
    }

    public static String specificToGeneral(String region){
        String strUrl = "";
        if(region.equals("EUN1") || region.equals("EUW1") || region.equals("RU1") || region.equals("TR1") ){
            strUrl = "europe";
        }
        if(region.equals("BR1") || region.equals("LA1") || region.equals("LA2") || region.equals("NA1")){
            strUrl = "americas";
        }
        if(region.equals("KR") || region.equals("JP1") ||  region.equals("PH2") || region.equals("TW2") ){
            strUrl = "asia";
        }
        if(  region.equals("OCE") ||  region.equals("OCE1") || region.equals("SG2") || region.equals("TH2") || region.equals("VN2") ){
            strUrl = "sea";
        }


//        switch (region) {
//            case "EUN1", "EUW1", "RU1", "TR1" -> strUrl = "europe";
//            case "BR1", "LA1", "LA2", "NA1" -> strUrl = "americas";
//            case "KR", "JP1", "PH2", "SG2", "TW2", "TH2", "VN2" -> strUrl = "asia";
//            case "OCE", "OCE1" -> strUrl = "sea";
//        }

        return strUrl;
    }

}
