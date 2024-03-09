# Gilded Rose Implementation Steps

This file contains some extra information on the steps I've taken to go through the gilded rose exercise, separated per commit.

## Creation of test classes and tests

I started the exercise by writing tests to cover all functionality of the gilded rose. These tests are separated in
three test classes, each testing different things.

- The first test class is the GildedRoseSingleDayTest. This test class tests a one-day loop of all different items with
the necessary edge cases per item.
- The second test class is the GildedRoseMultipleDaysTest. This test class tests a multiple days loop and will check
everything at the 5 day, the 10 day and the 15 day point. This class also contains code to test a conjured item in the
multiple days cycle, but this item will be commented out until the code for conjured items is added.
- Finally, the third test class is the GildedRoseConjuredTest class. This test class will test all conjured variants of
the existing items and some edge cases. I only started using this test class as soon as I wrote the code for conjured
items.

## Creation of constants + first simplification of updateQuality method

I started this step by creating constants of all strings in the updateQuality method. Next to the creation of constants
I did some first simplification steps of the method, namely extracting the sulfuras checks to just one check surrounding
the other code of the method, merging some if statements and changing the for loop to a foreach loop.

## Remove duplicated code by creating methods

In this step I started by creating two more constants, namely for the minimum and maximum quality of an item. After that
I tried to remove as much of the duplicated code in the method as possible, by creating some helper methods in the class.

## Improve readability by removing negations

This step was mostly a preparation for what I was planning on doing in the next step and mainly made the code more
readable for me personally, as I find it a lot clearer to read code that isn't entirely made up of negations in if
statements. The removing of negations also made it a lot clearer to see what happens in case of a certain item,
instead of what doesn't happen to a certain item.

## Change updateQuality method to handle different items separately instead of in nested if else statements

This step finally starts taking care of all hard to read if else statements. First I added some extra helper methods
to reduce code duplication and improve readability. After that I changed up the updateQuality method in a rather big
way by merging all if statements per item, in this way it became a lot more clear what happened in case of each item
and made it a lot easier to debug certain errors that may occur during the refactoring.

## Handling of different objects put in separate methods

This was again a rather small step in preparation of the next step. In this step I moved the code for each item to
a separate method which handles the updating of the item.

## Created separate wrapper classes for all different item types + added conjured functionality to all items

This step contains a very big refactor where I created an abstract wrapper class and wrapper classes for all items. The
wrapper class contains all helper methods used for updating the quality and sellIn of the items, as well as the item
that is being wrapped and an abstract method updateQualityAndSellIn. All item wrapper classes implement the
updateQualityAndSellIn method with the code that was originally present in the handler methods in the GildedRose class.

The wrapper classes gave me a good opportunity to add a way to process conjured items. I did this by adding a variable
to the wrapper classes, conjuredMultiplier, this variable is given the value 1 if the item is not conjured and 2 if the
item is conjured. The conjuredMultiplier is then used in the methods which increase and decrease the quality of items.

## Extracted creation of ItemWrappers from GildedRose to ItemWrapperCreator + small styling changes

In this final step I moved the creation of the different ItemWrappers to a new class, the ItemWrapperCreator, this
class is given the responsibility of providing the correct ItemWrapper for a given item. Next to this I also added
some small styling changes to make the styling the same throughout all files.
