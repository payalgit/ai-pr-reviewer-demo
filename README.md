# ai-pr-reviewer-demo

## Shape APIs

The application exposes two `GET` APIs. Dimensions are supplied as query parameters and the response is a JSON number.

```text
GET /api/shapes/{shape}/area
GET /api/shapes/{shape}/volume
```

Supported area shapes: `circle` (`radius`), `rectangle` (`length`, `width`), `square` (`side`), and `triangle` (`base`, `height`).

Supported volume shapes: `sphere` (`radius`), `cube` (`side`), `cylinder` (`radius`, `height`), and `rectangular-prism` (`length`, `width`, `height`).

Examples:

```text
GET /api/shapes/circle/area?radius=2
GET /api/shapes/cylinder/volume?radius=2&height=5
```

Invalid shapes or dimensions return `400 Bad Request`.
