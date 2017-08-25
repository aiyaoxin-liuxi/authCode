package com.authCode.util.auth;




public class AuthCodeDecode {
    
    public static String decodeEntry(){
        String decodeKey = "";
        try {
            String key = PropsHandler.getProperty("key");;
            String privateKey = "".equals(PropsHandler.getProperty("private.key")) ? null : PropsHandler.getProperty("private.key");
            
            decodeKey = decode(key, privateKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return decodeKey;
    }
    
    private static String decode(String key) throws Exception{
        return decode(key, null);
    }
    
    private static String decode(String key, String privateKey) throws Exception{
        String decodeKey = null;
        if(null == privateKey){
            // base64
            decodeKey = base64Decode(key);
        } else if(null != privateKey){
            // RSA
            decodeKey = RSADecode(key, privateKey);
        }
        return decodeKey;
    }
    
    private static String base64Decode(String mi){
        return new String(EncodeUtils.base64Decode(mi));
    }
    
    private static String RSADecode(String mi, String privateKey) throws Exception{
        return RSAUtil.decrypt(mi, "UTF-8", privateKey);
    }
    
    
    public static void main(String[] args) throws Exception {
        
        System.out.println(AuthCodeDecode.decodeEntry());
        
        
//        AuthCodeDecode t = new AuthCodeDecode();
//        
//        //base64
//        String mi = "MjAxNzA4Mjblhazlj7jlkI3np7A=";
//        System.out.println(t.decode(mi));
        //RSA
//        String mi = "N6HzU%2FvKnOYbitWjMhbEnusTD3DB4pJDs%2By283c4hTooEzixG5q8GVcIt8OFf2hGtlqz9BlP7BxlN7ugeiqUEA%3D%3D";
//        String privateKey = "MIIBVAIBADANBgkqhkiG9w0BAQEFAASCAT4wggE6AgEAAkEAkZkC4vaSm6jeAMU22ospdaVUFwHWcGhbMWjtlWbw33lWj9VQ61QKsxKa8UzhlfGX6djL0q7lUwR/aXohjtkvJwIDAQABAkBJmGVsIiTzR8WH8CgNCgDX9czuoEArq6RE8nv9Y/5nhuK3vlI0C4l2RrqZwNeEZlZKIo4XkpmrMmt1K1CrPbRZAiEA1cyh/Vpq4LhQGFK1MjFYJEiHJMTbzSEiqFXqOWdq1bsCIQCuVh8uLQvF5dTTfsv6MFZShzcs3Ein/P4Ax2vpbrufhQIgZtb7xIZNirKdtFV0WyRpJWrNtt4KbG1X4mkRNXONbCkCIBBALOXkAw3ub5lLX34x1UoaGpWO7yLhnVe7Px7iWJD1AiEAs10+VBrlDyvq6nu71yZIJfBoBCI7yGDAS2zm4lMQG9g=";
//        String drpStr = t.decode(mi, privateKey);
//        System.out.println("drpStr:" + drpStr);
//        System.out.println("==================================");
        
    }

}
