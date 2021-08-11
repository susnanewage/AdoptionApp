package com.example.adoptionapp.model

import com.example.adoptionapp.R


object DataProvider {
    val puppyModel =
        PuppyModel(
            id = 1,
            name = "Labrador Retriever",
            sex = "Male",
            lifeSpan = "10-12 Years",
            orgin = "Canada",
            color = "White",
            description = "The Labrador Retriever is an enthusiastic hunter with a good nose and a soft mouth. They excel in all performance activities. Another essential characteristic of the Labrador Retriever is the short, dense, double coat that protects the dog when retrieving from water.",
            price = "$800 - $1500",
            img = R.drawable.labrador
        )

    val puppyList = listOf(
        puppyModel,
        PuppyModel(
            id = 2,
            name = "French Bulldog",
            sex = "Female",
            lifeSpan = "10-12 Years",
            orgin = "France",
            color = "White & Brindle",
            description = "The French bulldog is a clown in a lap dog. It enjoys playing and entertaining its family, as well as cuddling and snoozing with its favorite person. It is amiable, sweet, companionable and willing to please.",
            price = "$2000 - $4000",
            img = R.drawable.frenchbulldog
        ),
        PuppyModel(
            id = 3,
            name = "German Shepherd Dog",
            sex = "Male",
            lifeSpan = "10-13 years",
            orgin = "Germany",
            color = "Black and Tan",
            description = "The German Shepherd Dog is confident and fearless, willing to be approached, yet a certain level of aloofness towards strangers is acceptable.",
            price = "$800 - $2000",
            img = R.drawable.germanshepherd
        ),
        PuppyModel(
            id = 4,
            name = "Golden Retriever",
            sex = "Female",
            lifeSpan = "10-12 Years",
            orgin = "United Kingdom",
            color = "Dark Golden",
            description = "The Golden Retriever is a medium-sized to large, well-balanced dog with a distinctive golden-colored coat; small, drop ears; and a natural tail carried level with the back or with a slight upward curve. ",
            price = " $1000 - $2000",
            img = R.drawable.goldenretriever
        ),
        PuppyModel(
            id = 5,
            name = "Bulldog",
            sex = "Male",
            lifeSpan = "8-10 years",
            orgin = "United Kingdom",
            color = "Brindle & White",
            description = "The English Bulldog is a wide, medium-sized, compact dog with short legs. The body and head are massive with extra skin on both the skull and forehead falling in folds. ",
            price = "$2000 - $4000",
            img = R.drawable.bulldog
        ),
        PuppyModel(
            id = 6,
            name = "Poodle",
            sex = "Female",
            lifeSpan = "12-15 years",
            orgin = "France, Germany",
            color = "Apricot",
            description = "The Standard Poodle is a medium-sized, squarely built dog with a distinctive harsh curly coat that may be presented in any of several traditional Poodle clips or corded. ",
            price = "$800 - $1500",
            img = R.drawable.poodle
        ),
        PuppyModel(
            id = 7,
            name = "Pembroke Welsh Corgi",
            sex = "Male",
            lifeSpan = "12-14 years",
            orgin = "United Kingdom",
            color = "Fawn",
            description = "The Pembroke Welsh Corgi is moderately long and low, and less heavily boned than the Cardigan Welsh corgi. Its movement is free and smooth, with good reach and drive. ",
            price = "$1000 - $2000",
            img = R.drawable.pembroke
        ),
        PuppyModel(
            id = 8,
            name = "Cavalier King Charles Spaniel",
            sex = "Female",
            lifeSpan = "10-14 years",
            orgin = "United Kingdom",
            color = "Ruby",
            description = "The Cavalier King Charles Spaniel is an elegant, royal, toy spaniel, slightly longer than tall, with moderate bone. It retains the build of a working spaniel, yet in a smaller version.",
            price = "$1200 - $2000",
            img = R.drawable.cavalier
        ),
        PuppyModel(
            id = 9,
            name = "Shih Tzu",
            sex = "Female",
            lifeSpan = "10-16 years",
            orgin = "China",
            color = "Silver",
            description = "The Shih Tzu, also known as the ‘Chinese Lion Dog’, ‘Chrysanthemum Dog’ (because its face resembles a flower), or ‘Shih Tzu Kou’ (which translates to ‘Lion Dog’, designating its revered status in Buddhism) originates in Tibet as far back as the 1600’s.",
            price = "$800 - $1500",
            img = R.drawable.shih
        ),
        PuppyModel(
            id = 10,
            name = "Siberian Husky",
            sex = "Female",
            lifeSpan = "12-14 years",
            orgin = "Russia",
            color = "Black & White",
            description = "The Siberian Husky combines power, speed and endurance, enabling it to carry a light load at moderate speed over a great distance.",
            price = "$600 - $1000",
            img = R.drawable.siberian
        )
    )
}