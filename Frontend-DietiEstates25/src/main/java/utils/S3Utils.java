package utils;

import java.awt.Image;
import java.io.File;
import java.io.InputStream;
import java.nio.file.Path;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

public class S3Utils {
	
	
	
	public S3Utils() {
	}
	
	
	
	public ImageIcon getIconFromS3(String foto) {
		String bucketName = "dietiestates25-bucket";
        String region = "eu-central-1"; 
        String accessKey = "AKIAUZPNLDS3IPKBLMEX";
        String secretKey = "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";

       
        S3Client s3 = S3Client.builder()
                .region(software.amazon.awssdk.regions.Region.of(region))
                .credentialsProvider(StaticCredentialsProvider.create(
                        AwsBasicCredentials.create(accessKey, secretKey)))
                .build();

    
        InputStream imageStream;
        try {
            imageStream = s3.getObject(GetObjectRequest.builder()
                    .bucket(bucketName)
                    .key(foto)
                    .build());
        } catch (Exception e) {
            imageStream=null;
        }
       
        if (imageStream != null) {
            return getImageIcon(imageStream);
        }
		return null;
	}
	private ImageIcon getImageIcon(InputStream imageStream) {
        try {
            
            Image image = ImageIO.read(imageStream);

         
            ImageIcon imageIcon = new ImageIcon(image);
            ImageIcon resizedIcon = resizeImageIcon(imageIcon, 120, 120);
            return resizedIcon;
        } catch (Exception e) {
            return null;
        }
    }
	private ImageIcon resizeImageIcon(ImageIcon imageIcon, int larghezza, int altezza) {
		Image image = imageIcon.getImage();
        Image newImage = image.getScaledInstance(larghezza, altezza, Image.SCALE_SMOOTH);
        return new ImageIcon(newImage);
	}
	public boolean uploadToS3(File file) {
        try {
        	String bucketName = "dietiestates25-bucket";
            String region = "eu-central-1"; 
            String accessKey = "AKIAUZPNLDS3IPKBLMEX";
            String secretKey = "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";
            S3Client s3 = S3Client.builder()
                    .region(software.amazon.awssdk.regions.Region.of(region))
                    .credentialsProvider(StaticCredentialsProvider.create(
                            AwsBasicCredentials.create(accessKey, secretKey)))
                    .build();

            
            String objectKey =file.getName(); 
            s3.putObject(PutObjectRequest.builder()
                            .bucket(bucketName)
                            .key(objectKey)
                            .build(),
                    RequestBody.fromFile(Path.of(file.getAbsolutePath())));

            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
