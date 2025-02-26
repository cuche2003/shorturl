<a id="readme-top"></a>

[![Contributors][contributors-shield]][contributors-url]
[![Forks][forks-shield]][forks-url]
[![Stargazers][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-url]
[![Unlicense License][license-shield]][license-url]


<!-- PROJECT LOGO -->
<br />
<div align="center">
  <h3 align="center">Shorturl</h3>

  <p align="center">
    An awesome URL Shortener that lets you customize with your own shortcut!
    <br />
    <br />
    <a href="https://github.com/cuche2003/shorturl">View Demo</a>
    &middot;
    <a href="https://github.com/cuche2003/shorturl/issues/new?labels=bug&template=bug-report---.md">Report Bug</a>
    &middot;
    <a href="https://github.com/cuche2003/shorturl/issues/new?labels=enhancement&template=feature-request---.md">Request Feature</a>
  </p>
</div>



<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#roadmap">Roadmap</a></li>
    <li><a href="#contributing">Contributing</a></li>
    <li><a href="#license">License</a></li>
    <li><a href="#contact">Contact</a></li>
    <!-- <li><a href="#acknowledgments">Acknowledgments</a></li> -->
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## About The Project

There are many great URL shorteners available online. However, I didn't find one that allowed users to customize their own shortcut, so I created this enhanced one. Although this was made solely for educational purpose, you may use it to make your own (better) URL shortener if you may.

<p align="right">(<a href="#readme-top">back to top</a>)</p>


### Built With

* [![Spring][Spring-logo]][Spring-url]
* [![Spring Boot][SpringBoot-logo]][SpringBoot-url]
* [![Swagger][Swagger-logo]][Swagger-url]

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- GETTING STARTED -->
## Getting Started

To get a local copy up and running follow these simple example steps.

### Prerequisites

- JDK 21.

### Installation

To get a local copy up, follow the following steps.

1. Clone the repo
   ```sh
   git clone https://github.com/cuche2003/shorturl.git
   cd shorturl
   ```
3. Initialize Gradle project
   ```sh
   ./gradlew init
   ```
4. Start the development server
   ```sh
   ./gradlew bootRun
   ```
5. Go to `localhost:8080/swagger-ui/index.html` to explore the API.

<p align="right">(<a href="#readme-top">back to top</a>)</p>


<!-- USAGE EXAMPLES -->
## Usage

![image](https://github.com/user-attachments/assets/0d767256-1aaf-41aa-a858-cf9ac856d4b3)


<p align="right">(<a href="#readme-top">back to top</a>)</p>


<!-- ROADMAP -->
## Roadmap

- [x] Can shorten links
- [x] Delete expired links every hour
- [x] Angular front-end to see links and shorten link
- [x] Redirect to full url on front-end
- [ ] Improved UI/UX
- [ ] Optimization

See the [open issues](https://github.com/cuche2003/shorturl/issues) for a full list of proposed features (and known issues).

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- CONTRIBUTING -->
## Contributing

Contributions are what make the open source community such an amazing place to learn, inspire, and create. Any contributions you make are **greatly appreciated**.

If you have a suggestion that would make this better, please fork the repo and create a pull request. You can also simply open an issue with the tag "enhancement".
Don't forget to give the project a star! Thanks again!

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

### Top contributors:

<a href="https://github.com/cuche2003/shorturl/graphs/contributors">
  <img src="https://contrib.rocks/image?repo=cuche2003/shorturl" alt="contributors"/>
</a>

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- LICENSE -->
## License

Distributed under the GPLv3.0 License. See `LICENSE.txt` for more information.

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- CONTACT -->
## Contact

Nguyen Tuyen - nguyentuyen.business@gmail.com

Project Link: [https://github.com/cuche2003/shorturl](https://github.com/cuche2003/shorturl)

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- ACKNOWLEDGMENTS -->
<!--
## Acknowledgments

Use this space to list resources you find helpful and would like to give credit to.

<p align="right">(<a href="#readme-top">back to top</a>)</p>
-->


<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[contributors-shield]: https://img.shields.io/github/contributors/cuche2003/shorturl.svg?style=for-the-badge
[contributors-url]: https://github.com/cuche2003/shorturl/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/cuche2003/shorturl.svg?style=for-the-badge
[forks-url]: https://github.com/cuche2003/shorturl/network/members
[stars-shield]: https://img.shields.io/github/stars/cuche2003/shorturl.svg?style=for-the-badge
[stars-url]: https://github.com/cuche2003/shorturl/stargazers
[issues-shield]: https://img.shields.io/github/issues/cuche2003/shorturl.svg?style=for-the-badge
[issues-url]: https://github.com/cuche2003/shorturl/issues
[license-shield]: https://img.shields.io/github/license/cuche2003/shorturl.svg?style=for-the-badge
[license-url]: https://github.com/cuche2003/shorturl/blob/master/LICENSE
[Spring-logo]: https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white
[Spring-url]: https://spring.io
[SpringBoot-logo]: https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white
[SpringBoot-url]: https://spring.io/projects/spring-boot
[Swagger-logo]: https://img.shields.io/badge/Swagger-85EA2D?style=for-the-badge&logo=Swagger&logoColor=white
[Swagger-url]: https://swagger.io/
