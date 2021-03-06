var tests = [
       {"name": "connect movie lens source", "url": "/sources", "method": "PUT", "params": {"connection-id": "ml", "source-id": "ml-100", "dir": "C:/Privat/3_Uni/5_Workspaces/data/ml-1m"}, "result": {"status": 200, "minLength": 1}},
       {"name": "list sources", "url": "/sources", "method": "GET", "params": {"output": "text", "mimeType": "text/plain"}, "result": {"status": 200, "minLength": 10}},
       {"name": "get movie lens source", "url": "/sources/ml-100", "method": "GET", "params": {}, "result": {"status": 200, "minLength": 1}},
       {"name": "get movie lens users", "url": "/data/sources/ml-100/users", "method": "GET", "params": {}, "result": {"status": 200, "minLength": 1}},
       {"name": "get movie lens user", "url": "/data/sources/ml-100/users/113", "method": "GET", "params": {}, "result": {"status": 200, "minLength": 1}},
       {"name": "get movie lens items", "url": "/data/sources/ml-100/items", "method": "GET", "params": {}, "result": {"status": 200, "minLength": 1}},
       {"name": "get movie lens item", "url": "/data/sources/ml-100/items/2559", "method": "GET", "params": {}, "result": {"status": 200, "minLength": 1}},
       {"name": "get movie lens interactions", "url": "/data/sources/ml-100/users/6040/items/2745", "method": "GET", "params": {}, "result": {"status": 200, "minLength": 1}},
       {"name": "get available recommender", "url": "/train", "method": "GET", "params": {}, "result": {"status": 200, "minLength": 1}},
       {"name": "train most popular recommender on movie-lens", "url": "/train/sources/ml-100", "method": "PUT", "params": {"rec-id": "most-popular", "id": "movielens-mp"}, "result": {"status": 200, "minLength": 1}},
       {"name": "get trained recommender state", "url": "/train/movielens-mp", "method": "GET", "params": {}, "result": {"status": 200, "minLength": 1}},
       {"name": "get most popular recommender on movie-lens", "url": "/rec/movielens-mp", "method": "GET", "params": {}, "result": {"status": 200, "minLength": 1}},
       {"name": "get most popular recommender on movie-lens for user", "url": "/rec/movielens-mp", "method": "GET", "params": {"user-id": "113"}, "result": {"status": 200, "minLength": 1}}
     //  {"name": "delete movie lens source", "url": "/sources/ml-100", "method": "DELETE", "params": {}, "result": {"status": 200, "text": "Data source with id ml-100 successful deleted.", "mimeType": "text/plain"}},
  ];