ALTER TABLE note
    ALTER COLUMN dealissues TYPE TEXT USING (dealissues::TEXT);

ALTER TABLE note
    ALTER COLUMN discussionpoints TYPE TEXT USING (discussionpoints::TEXT);