package models;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.util.ArrayList;
import java.util.Map;

// Key = c6f53a062b31d5a36fb5b146
public record DataConversion(Double USD,
                             Double MXN,
                             Double ARS,
                             Double COP,
                             Double EUR,
                             Double TRY
                             ) {

}
