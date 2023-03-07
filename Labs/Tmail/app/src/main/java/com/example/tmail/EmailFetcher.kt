package com.example.tmail

class EmailFetcher {
    // Will return an initial list of 10 emails
    // Wll alwasy use the same subject line and email content. Change it so its always different.
    companion object {
        val senders = listOf("Dahlia Cline", "Kevin Miranda", "Kaya Austin", "Laila Calderon", "Marquise Rhodes", "Fletcher Patel", "Luz Barron", "Kamren Dudley", "Jairo Foster", "Lilah Sandoval", "Ansley Blake", "Slade Sawyer", "Jaelyn Holmes", "Phoenix Bright", "Ernesto Gould")
        val title = "Welcome to the Neighborhood"
        val summary = "Welcome to the Neighborhood. We're excited to have you join us and learn how. Here are some tips to get started."
        fun getEmails(): MutableList<Email> {
            var emails : MutableList<Email> = ArrayList()
            for (i in 0..9) {
                val email = Email(senders[i], title, summary)
                emails.add(email)
            }
            return emails
        }

        /**
         * Will return the next 5 emails (stretch feature)
         */
        fun getNext5Emails(): MutableList<Email> {
            var newEmails : MutableList<Email> = ArrayList()
            for (i in 10..14) {
                val email = Email(senders[i], title, summary)
                newEmails.add(email)
            }
            return newEmails
        }
    }
}
