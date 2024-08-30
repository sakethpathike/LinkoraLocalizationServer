`LinkoraLocalizationServer` powers [Linkora](https://github.com/sakethpathike/Linkora)'s remote strings, which can be
used in the app alongside locally
available languages and their respective strings.

- The idea of localization in Linkora is pretty straightforward. Strings are added by the community, and once they’re
  done, those strings with their respective languages can be fetched from the Linkora app.

# Contribution:

The following detailed guide will help you contribute to language strings via Crowdin:

1. Visit [Linkora on Crowdin](https://crowdin.com/editor/linkora/all), create an account (if you don't have one), and
   log in.
2. Select the language of the strings that you want to contribute to:
   ![](https://github.com/user-attachments/assets/3dee82fc-4466-491d-984c-ac4791268f3c)
    - If the language you're looking to contribute to doesn't exist, please create an issue in this repository, and it
      will be added. If it already exists, proceed further.
3. Add the respective translation and click save.
   ![](https://github.com/user-attachments/assets/281a7e3c-3194-47ea-934c-5ecdf70c11f6)

#### Dynamic String Values

The following values of string keys will get replaced at runtime with the folder name or another relevant value:

1. `syncing_translations_for_this_may_take_some_time`
2. `edit_panel_name`
3. `are_you_sure_want_to_delete_the_panel`
4. `are_you_sure_want_to_delete_the_folder`
5. `rename_folder`
6. `create_a_new_internal_folder_in`

- `\"$$$$\"` should be used as a placeholder in a string value. **Only `\"$$$$\"` should be used, as this is what the
  Linkora app will look for during runtime replacement.** For example, in English, the value of the string key
  `create_a_new_internal_folder_in` is:
  > Create a new internal folder in \\"$$$$\\":

  `\"$$$$\"` will be replaced by a folder name in this case.

  The same string in Hindi looks like:
  > \\"$$$$\\" में एक नया आंतरिक फ़ोल्डर बनाएं:

  You can notice that the position of the placeholder is different, which is common as every language has its own
  vocabulary and way of writing things.

    - According to the language you're contributing to, if you’re also contributing to these strings specifically, then
      use placeholders. The rest of the strings don’t need any placeholders.

- Remember, these placeholders should only be applied to the string keys (identifiers) listed above. The rest don’t need
  them.

And that's it! You’ve contributed to Linkora's string resources. If everything goes well, your contribution will be
reflected in the app's strings for the language you’ve contributed to.