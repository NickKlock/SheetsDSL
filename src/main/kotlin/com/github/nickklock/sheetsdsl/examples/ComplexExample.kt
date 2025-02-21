package com.github.nickklock.sheetsdsl.examples

import xyz.sheetsdsl.*
import com.github.nickklock.sheetsdsl.BorderSideDsl.TOP_BOTTOM
import com.github.nickklock.sheetsdsl.BorderStyleDsl.DOTTED
import com.github.nickklock.sheetsdsl.align
import com.github.nickklock.sheetsdsl.bg
import com.github.nickklock.sheetsdsl.rem
import com.github.nickklock.sheetsdsl.vAlign
import com.github.nickklock.sheetsdsl.HorizontalAlignmentDsl.CENTER
import com.github.nickklock.sheetsdsl.HorizontalAlignmentDsl.RIGHT
import com.github.nickklock.sheetsdsl.VerticalAlignmentDsl.MIDDLE
import java.awt.Color.*

fun main() {
    val spreadsheet = spreadsheet("Generated Spreadsheet") {
        sheet("First") {
            row {
                cell("Bold Roboto") {
                    font {
                        fontFamily = "Roboto"
                        bold = true
                    }
                }

                cell("White on red and aligned to right") {
                    font {
                        color = WHITE
                    }
                } bg RED align RIGHT

                +"Am I rotated?" % 45
            }

            columnWidth(1, 240)

            row(cellCount = 2) {
                cell("4 * 84 =") {
                    horizontalAlignment = RIGHT
                }
                cellFormula("= 4 * 84") {
                    backgroundColor = GRAY
                }
            }

            row()

            row {
                emptyCell()
                cell(4234.234) {
                    border(DOTTED, BLUE, TOP_BOTTOM)
                }
            }
        }

        sheet("second - empty")

        sheet {
            columnWidth(0..2, 150)
            columnWidth(3, 60)

            row(cellCount = 3) {
                cell("thin") {
                    font {
                        bold = true
                    }
                    horizontalAlignment = CENTER
                }
            }

            row(2)

            row(height = 63) {
                cell("tall") {
                    font {
                        bold = true
                    }
                } align CENTER vAlign MIDDLE
            }
        }
    }

    spreadsheet.openInBrowser()
}
