reqT.github.io
==============

reqT project web pages at https://reqt.github.io/ 

## How to build

Make sure you have [`scala`](https://www.scala-lang.org/) and [`pandoc`](https://pandoc.org/) and [`node`](https://nodejs.org/en/download) on path.

If you get `Error: Cannot find module 'jsdom'` then issue [these commands](https://scala-cli.virtuslab.org/docs/guides/advanced/scala-js/#scalajs-dom-support):
```
npm init private
npm install jsdom
```

Build everything with: `scala run build.scala`

## How to run

You can e.g. use [Live Server Preview in vscode](https://marketplace.visualstudio.com/items?itemName=ms-vscode.live-server) by pressing  Ctrl+Shift+P and start typing `Live Server: Open with Live Serve`.

## How to publish
For maintainers with push access: `git push` and it will be live after a while.
