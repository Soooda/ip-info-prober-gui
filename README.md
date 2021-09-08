# IP Info Prober with GUI

This code base is modified from one of my school project.

**Features**:

* JavaFX GUI

* Data caching
* Multi-threading

## Run

To run this project, simply do:

```bash
$ gradle run --args="<online/offline> <online/offline>"
```

with the first controlling the input API, and the second controlling the output API.

| API    | Online                                          | Offline                      |
| ------ | ----------------------------------------------- | ---------------------------- |
| Input  | Real information coming from [IP Geolocation](https://www.abstractapi.com/ip-geolocation-api) | Mock API for testing purpose |
| Output | [PasteBin](https://pastebin.com/doc_api)                                    | Command-line Text Output     |

## Configuration

### API Keys
**Please create a valid .env before running any testcases and using the application in online mode (for both input and output APIs), some may fail due to FileNotFoundException.**

Create a `.env` file under `src/main/resources/` with:
```bash
IP_API_KEY=<your_key>
PASTEBIN_API_KEY=<your_key>
```

### Database

> The database is for caching purpose.

`cache.db` is located under `src/main/resources`. By default, it is **empty**.

**Schema**:
```
sqlite> .schema
CREATE TABLE cache (ip string, json string);
```

`init.sql` in the same directory is provided for re-generating the database. To reset simply run:
```bash
$ rm cache.db
$ sqlite3 cache.db < init.sql
```

## References
GET/POST https://square.github.io/okhttp/
