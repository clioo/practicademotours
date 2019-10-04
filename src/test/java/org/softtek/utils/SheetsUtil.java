package org.softtek.utils;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.api.services.sheets.v4.model.ValueRange;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.List;

public class SheetsUtil {
    private static final String APPLICATION_NAME = "Google Sheets API Java Quickstart";
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    private static final String TOKENS_DIRECTORY_PATH = "tokens";
    private static final List<String> SCOPES = Collections.singletonList(SheetsScopes.SPREADSHEETS_READONLY);
    private static final String CREDENTIALS_FILE_PATH =	"/credentials.json";
    private NetHttpTransport HTTP_TRANSPORT = null;
    private String spreadsheetId;
    private String range;
    private Sheets service;
    public SheetsUtil() throws GeneralSecurityException, IOException {
      	 // Build a new authorized API client service.
           HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
           spreadsheetId = "1EuC-SAQ9bLjQw5zNR_QBltQz2-A8RydLNN-myoRDV7Y";//TO:DO get from the environment
           //A5 is the begining of the datatable, firs row is for headers
           service = new Sheets.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
                   .setApplicationName(APPLICATION_NAME)
                   .build();
    }
    
    private static Credential getCredentials(final NetHttpTransport HTTP_TRANSPORT) throws IOException {
        // Load client secrets.
        InputStream in = SheetsUtil.class.getResourceAsStream(CREDENTIALS_FILE_PATH);
        System.out.println(in);
        if (in == null) {
            throw new FileNotFoundException("Resource not found: " + CREDENTIALS_FILE_PATH);
        }
        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

        // Build flow and trigger user authorization request.
        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
                .setDataStoreFactory(new FileDataStoreFactory(new java.io.File(TOKENS_DIRECTORY_PATH)))
                .setAccessType("offline")
                .build();
        LocalServerReceiver receiver = new LocalServerReceiver.Builder().setPort(8888).build();
        return new AuthorizationCodeInstalledApp(flow, receiver).authorize("user");
    }

    
    public Object[] getData() throws IOException, GeneralSecurityException{
    	range = "A5:S1000"; //TO:DO get from the environment
       	String[][] tabArray = null;
        ValueRange response = this.service.spreadsheets().values()
                .get(this.spreadsheetId, this.range)
                .execute();
        List<List<Object>> values = response.getValues();
        if(values.size() > 1) {
        	int totalCols = values.get(0).size();
        	int totalRows = values.size() - 1;
        	tabArray = new String[totalRows][totalCols];
        	for (int indexRow = 0; indexRow < values.size() - 1; indexRow++) {
				Object[] row = values.get(indexRow + 1).toArray();
				for (int indexColumn = 0; indexColumn < row.length; indexColumn++) {
					String cell = row[indexColumn].toString();
					tabArray[indexRow][indexColumn] = cell;
				}
			}
        }

        return tabArray;
        
    }
    
    public String getBrowser() throws IOException {
    	range = "B2"; //TO:DO get from the environment
        ValueRange response = this.service.spreadsheets().values()
                .get(this.spreadsheetId, this.range)
                .execute();
        List<List<Object>> values = response.getValues();
    	return values.get(0).get(0).toString();
    }
}


