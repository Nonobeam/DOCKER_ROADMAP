After running command "docker volume inspect demo_db" (syntax: docker volume inspect + {volume_name})

```
[
    {
        "CreatedAt": "2023-12-12T03:50:31Z",
        "Driver": "local",
        "Labels": {
            "com.docker.compose.project": "demo",
            "com.docker.compose.version": "2.22.0",
            "com.docker.compose.volume": "db"
        },
        "Mountpoint": "/var/lib/docker/volumes/demo_db/_data",
        "Name": "demo_db",
        "Options": null,
        "Scope": "local"
    }
]
```