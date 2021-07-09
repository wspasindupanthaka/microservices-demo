package jasypt;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.iv.RandomIvGenerator;

public class TestJasypt {

    public static void main(String[] args) {
        StandardPBEStringEncryptor standardPBEStringEncryptor = new StandardPBEStringEncryptor();
        standardPBEStringEncryptor.setPassword("Demo_Pwd!2020"); //The key that we use to encrypt
        standardPBEStringEncryptor.setAlgorithm("PBEWithHMACSHA512AndAES_256"); //Algorithm
        standardPBEStringEncryptor.setIvGenerator(new RandomIvGenerator()); //IV Generator

        String result = standardPBEStringEncryptor.encrypt("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"); //The text that we want to encrypt
        System.out.println(result);
        System.out.println(standardPBEStringEncryptor.decrypt(result));
    }

}
