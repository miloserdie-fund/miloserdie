# miloserdie
Портал добровольцев.

![miloserdie.svg](logo.svg)


## Prerequisites

- Install [Java](https://github.com/adoptium) development kit.
- Install [Clojure](https://github.com/clojure/clojure) programming language.
- Install [Node](https://github.com/nodejs/node) JavaScript runtime.
- Install [Just](https://github.com/casey/just) command line runner.

## Quick Start

Both the backend and the frontend use the same port 7171.


1. Frontend

* Install dependencies

```shell
just init
```
* Start CLJS/JS pipeline

```shell
just frontend
```

* Start CSS pipeline

```shell
just tailwind
```


2. Backend
* Start REPL
```shell
just backend
```
* Start the Server from REPL

```clojure
(backend.core/-main)
```
